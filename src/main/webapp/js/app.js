require(["service",
    "jquery",
    "knockout",
    "validation",
    "messagePage"], function (s, $, ko, v, m) {

    var templateService = s.templateService;

    var TemplateViewModel = function (templateService)
    {
        var viewModel = this;

        viewModel.page = ko.observable('home');


        viewModel.show = function (pageName) {
            viewModel.page(pageName);
        }

        viewModel.form = v.validatable({
            name: ko.observable().extend({validations: [v.required]}),
            account: ko.observable().extend({validations:[]})
        });

        viewModel.save = function (data, event) {
            event.preventDefault();
            var formValue = ko.utils.unwrapObservable(viewModel.form);
            var options = {
                data: formValue,
                success: function () {
                    viewModel.success("Succes.");
                },
                error: function (jqXHR) {
                    function showGlobalError(jqXHR) {
                        viewModel.error("Error " + jqXHR.status + ": " + jqXHR.statusText);
                    }

                    if(jqXHR.status >= 400 && jqXHR.status < 500){
                       try{
                           var error = JSON.parse(jqXHR.responseText);
                       } catch(e){
                           showGlobalError(jqXHR);
                       }
                        if(error.errors || error.globalError){
                            viewModel.error(error.globalError);
                            formValue.errors(error.errors);
                        }else{
                            showGlobalError(jqXHR);
                        }
                    }else{
                        showGlobalError(jqXHR);
                    }
                }
            };
            if (typeof formValue.id !== 'undefined') {
                templateService.update(options);
            } else {
                templateService.save(options);
            }
        }
    }

    var templateViewModel = new TemplateViewModel(templateService);

    m.messagePage(templateViewModel);

    ko.applyBindings(templateViewModel);

});
