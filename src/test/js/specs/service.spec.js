require(['service'],
    function(service, $) {

        describe('Task: initialize', function() {
            it('should not be done', function() {
                 var templateService = service.templateService;
                expect(templateService.update).toBeTruthy();
            });


        });
    }
);
