define("validation", ["knockout"], function (ko) {

    ko.bindingHandlers.validation = {
        init: function (element, valueAccessor) {
            var form = ko.utils.unwrapObservable(valueAccessor());

            $.each(form.propertiesToValidate(), function (i, property) {
                var inputElement = $(element).find('#' + property.propertyName);
                $(inputElement).blur(function (ev) {
                    form.validateProp(ev.target.id);
                });
            });
        },
        update: function (element, valueAccessor, allBindingsAccessor, viewModel, bindingContext) {
        }
    };

    ko.bindingHandlers.errors = {
        init: function (element, valueAccessor, allBindingsAccessor, viewModel, bindingContext) {
            var errors = ko.utils.unwrapObservable(valueAccessor());
        },
        update: function (element, valueAccessor, allBindingsAccessor, viewModel, bindingContext) {
            var errors = ko.utils.unwrapObservable(valueAccessor()),
                jqElem = $(element);

            if (errors && errors.length > 0) {
                jqElem.closest('.control-group').addClass("error");
                jqElem.empty();
                $.each(errors, function (i, error) {
                    jqElem.append('<p>' + error.message + '</p>')
                });
            } else {
                jqElem.closest('.control-group').removeClass("error");
                jqElem.empty();
            }
        }
    };


    ko.extenders.validations = function (target, option) {
        target.validations = option;
        return target;
    };

    return {
        required: {
            validate: function (value) {
                return value !== null && value !== '' && value !== undefined;
            },
            message: " is required."
        },
        validatable: function (model) {

            function mustPropertyBevalidated(property) {
                return property.validations;
            }

            model.propertiesToValidate = function () {
                var properties = [];
                for (p in model) {
                    if (mustPropertyBevalidated(model[p])) {
                        properties.push(model[p]);
                    }
                }
                return properties;
            }

            for (p in model) {
                var property = model[p];
                property.propertyName = p;
                property.errors = ko.observable();
            }

            model.validateProp = function (id) {
                var property = model[id];
                var errors = [];
                if(property)
                $.each(property.validations, function (i, validation) {
                    if (!validation.validate(model[id]())) {
                        errors.push({
                            elementId: id,
                            message: validation.message
                        });
                    }
                });

                property.errors(errors);
            }

            model.errors = function (errors) {

                for(propertyName in errors) {
                    var property = model[propertyName];
                    if(!property){
                        throw "Error handling form error, propertyName: " + propertyName + " not known."
                    }
                    property.errors(errors[propertyName]);
                }
            }

            model.hasErrors = function () {
                var propertiesWithErrors = $.grep(model.propertiesToValidate(), function (property) {
                    return property.errors() && property.errors().length > 0
                });
                return propertiesWithErrors.length > 0;
            };

            return model;
        }
    };
});