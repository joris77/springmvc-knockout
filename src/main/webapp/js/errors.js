define("errors",["knockout"], function (ko) {
    return {
        errorPage: function (viewModel) {
            viewModel = viewModel || {};

            viewModel.globalError = ko.observable();

            viewModel.handle = function (errorViewModel) {
                if (errorViewModel.globalError) {
                    viewModel.globalError(errorViewModel.globalError);
                }
            }
        }
    }
});