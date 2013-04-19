requirejs.config({
    baseUrl: 'js',

    paths: {
        jquery: "lib/jquery/jquery-1.8.2",
        knockout: "lib/knockout/knockout-2.2.0",
        knockoutmapping: "lib/knockout/knockout.mapping",
        jqueryui: "lib/jquery/jquery-ui-1.9.1.custom"
    },
    shim: {
        'jquery': {
            exports: '$'
        },
        'jqueryui': {
            deps: ['jquery'],
            exports: '$'
        }
    }
});