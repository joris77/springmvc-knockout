define("messagePage", ["knockout"], function (ko) {
    return {
        messagePage: function (viewModel) {
            viewModel = viewModel || {};

            viewModel.message = ko.observable();

            viewModel.error = function (errorMessage) {
                if (errorMessage) {
                    viewModel.message({
                        messageText: errorMessage,
                        type: 'alert-error'
                    });
                }
            }

            viewModel.info = function (infoMessage) {
                if (infoMessage) {
                    viewModel.message({
                        messageText: infoMessage,
                        type: 'alert-info'
                    });
                }
            }

            viewModel.success = function (message) {
                if (message) {
                    viewModel.message({
                        messageText: message,
                        type: 'alert-success'
                    });
                }
            }

            viewModel.removeMessage = function () {
                viewModel.message(null);
            }
        }
    }
});