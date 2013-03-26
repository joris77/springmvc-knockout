var ViewModel = function () {
    var viewModel = this;

    viewModel.page = ko.observable('home');


    viewModel.show = function(pageName){
        viewModel.page(pageName);
    }

    viewModel.form = ko.observable({
        name: ""
    });

    viewModel.save = function (data,event) {
        event.preventDefault();
        var formValue = ko.utils.unwrapObservable(viewModel.form);
        if (typeof formValue.id !== 'undefined') {
            $.ajax({
                async: false,
                url: "/service/templates/" + formValue.id,
                type: "PUT",
                dataType: "json",
                contentType: 'application/json',
                data: JSON.stringify(formValue),
                success: function (data) {
                    console.log("Edit success");
                }
            });
        } else {
            $.ajax({
                async: false,
                url: '/service/templates',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(formValue),
                dataType: "json",
                success: function (data) {
                    console.log("Create success " + data.id);
                    viewModel.form().id = data.id;
                }
            });
        }

    }
}

$(ko.applyBindings(new ViewModel()));