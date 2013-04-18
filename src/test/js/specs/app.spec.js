define(['service', 'jquery'],
    function(service, $) {

        describe('Task: initialize', function() {
            it('should not be done', function() {
                var templateService = service.templateService;
                templateService.specificFunction();
            });

            it('should store and allow reading back the title', function() {
            });
        });
    }
);
