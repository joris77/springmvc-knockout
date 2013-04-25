define(['service', 'jquery'],
    function(service, $) {

        describe('Task: initialize', function() {
            it('should have an update method', function() {
                var templateService = service.templateService;
                expect(templateService.update).toBeTruthy();
            });

            it('should store and allow reading back the title', function() {
            });
        });
    }
);
