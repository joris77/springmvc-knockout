define("service", ["jquery"], function ($) {

    /**
     *  Enhances a service with the standard crud methods. This service is mainly a wrapper around $.ajax function of jquery.
     *  One can use the standard jquery options plus the ones described in the doc. The content and dataType are Json by
     *  default. The communication is asynchronous.
     *
     * @param properties object literal with properties
     *      url: the base url for the service
     * @param serviceToExtend  the service with specific methods. This service will be enhanced with the standard service
     *      methods.
     * @returns {*}
     */
    var service = function (properties, serviceToExtend) {

        serviceToExtend = serviceToExtend || {};

        var modelUrl = '/service/' + properties.url;

        function ajax(options) {

            $.ajax({
                async: true,
                url: options.url || modelUrl,
                type: options.type,
                contentType: options.contentType || 'application/json',
                data: JSON.stringify(options.data),
                dataType: options.dataType || "json",
                success: success,
                error: error
            });
        }

        function modelInstanceUrl(options) {
            return  modelUrl + '/' + options.id;
        }

        return $.extend(serviceToExtend, {
            /**
             *
             * @param options
             *      id: the id of the resource to find
             */
            find: function (options) {
                options.type = 'GET';
                options.url = modelInstanceUrl(options);
                ajax(options);
            },
            /**
             *
             * @param options
             */
            search: function (options) {
                options.type = 'GET';
                ajax(options);
            },
            /**
             *
             * @param options
             *      id: the id of the resource to find
             */
            delete: function (o) {
                options.type = 'DELETE';
                options.url = modelInstanceUrl(options);
                ajax(options);
            },
            save: function (options) {
                options.type = 'POST';
                ajax(options);
            },
            update: function (options) {
                options.type = 'PUT';
                options.url = modelInstanceUrl(options);
                ajax(options);
            }
        });
    }

    return {
        templateService: service({url: "templates"}, {
            specificFunction: function () {
                console.log('specific')
            }
        })
    };

});