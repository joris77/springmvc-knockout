require(["validation"],function(v){

    var model = {
        name:"joris",
        validate: function(){

        }
    };

    describe('validation', function() {
        describe('validatable', function(){
            it('should add a validateProperty function', function() {
                v.validatable(model);
                var errors = model.validateProp('', required);
                expect(errors)
            });
        });

        describe('required', function(){
            it('should add a required function', function() {
                v.validatable(model);
                expect(model.required(model.name)).toBeTruthy();
            });
        });
    });
});