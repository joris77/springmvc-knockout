define("sorting", ["knockout"], function () {
    var self = this;

    self.value = function (value, propertyName) {
        var propertyNames = propertyName.split(".");

        _v = function () {
            if (propertyNames.length === 1) {
                return value[propertyNames[0]];
            } else {
                var propertyName = propertyNames.shift();
                value = value[propertyName];
                return value !== null ? _v() : null;
            }
        }

        return _v();
    };
    self.sortable = function (obsArray) {
        obsArray.sortOnProperty = function (args) {
            obsArray.sort(function (l, r) {
                var leftValue = self.value(l, args.property);
                var rightValue = self.value(r, args.property);
                if (args.asc) {
                    return leftValue > rightValue || rightValue == null ? 1 : -1
                } else {
                    return leftValue < rightValue || leftValue === null ? 1 : -1
                }
            });
        }
    };
    return self;
});