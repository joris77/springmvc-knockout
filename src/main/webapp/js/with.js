var ViewModel = function () {
    var viewModel = this;

    viewModel.person = ko.observable();

    viewModel.findPerson = function(){
        viewModel.person({firstName:"joris"});
    }

    viewModel.findPersonBas = function(){
        viewModel.person({firstName:"Bas"});
    }

    viewModel.clearPerson = function(){
        viewModel.person(null);
    }
}

var viewModel = new ViewModel();

errorPage(viewModel);

$(ko.applyBindings(viewModel));