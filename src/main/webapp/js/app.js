require(["service",
    "jquery",
    "knockout",
    "validation"], function (s, $, ko,v) {

    var templateService = s.templateService;

    var TemplateViewModel = function (templateService)
    {
        var viewModel = this;

        viewModel.page = ko.observable('home');


        viewModel.show = function (pageName) {
            viewModel.page(pageName);
        }

        viewModel.form = v.validatable({
            name: ko.observable().extend({label: "Name", validations: [v.required]}),
            account: ko.observable(),
            accountErrors: ko.observableArray()
        });

        viewModel.save = function (data, event) {
            event.preventDefault();
            var formValue = ko.utils.unwrapObservable(viewModel.form);
            if (typeof formValue.id !== 'undefined') {
                templateService.update(formValue);
            } else {
                templateService.save(formValue)
            }
        }
    }

    var templateViewModel = new TemplateViewModel(templateService);

    ko.applyBindings(templateViewModel);

});
