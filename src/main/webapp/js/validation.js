define("validation", ["knockout"], function (ko) {

    ko.bindingHandlers['validation'] = {


        // This will be called when the binding is first applied to an element
        // Set up any initial state, event handlers, etc. here
        'init': function (element, valueAccessor) {
            var form = valueAccessor();

            $.each(form.propertiesToValidate, function (i) {
                var inputElement = $(element).find('#' + this.propertyName);
                $(inputElement).blur(function (ev) {
                    form.validateProp(this.id);
                });
            });


            //$(element).find('.error-message').remove();
        },
        'update': function (element, valueAccessor, allBindingsAccessor, viewModel, bindingContext) {
        }
    };

    ko.bindingHandlers['errors'] = {
        'init': function (element, valueAccessor, allBindingsAccessor, viewModel, bindingContext) {
            var errors = ko.utils.unwrapObservable(valueAccessor());
        },
        'update': function (element, valueAccessor, allBindingsAccessor, viewModel, bindingContext) {
            var errors = ko.utils.unwrapObservable(valueAccessor()),
                jqElem = $(element);

            if (errors && errors.length > 0) {
                jqElem.closest('.control-group').addClass("error");
                jqElem.empty();
                $.each(errors, function () {
                    jqElem.append('<p>' + this.message + '</p>')
                });
            } else {
                jqElem.closest('.control-group').removeClass("error");
                jqElem.empty();
            }
        }
    };


    ko.extenders.label = function (target, option) {
        target.label = option;
        return target;
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
            model.propertiesToValidate = [];

            for (p in model) {
                if (model[p].validations) {
                    model[p].propertyName = p;
                    model[p].errors = ko.observable();
                    model.propertiesToValidate.push(model[p]);
                }
            }

            model.validateProp = function (id) {
                var property = model[id];
                var errors = [];
                $.each(property.validations, function () {
                    if (!this.validate(model[id]())) {
                        errors.push({
                            elementId: id,
                            message: property.label + this.message
                        });
                    }
                });

                property.errors(errors);
            }

            model.errors = function(errors){

            }

            return model;
        }
    };

});