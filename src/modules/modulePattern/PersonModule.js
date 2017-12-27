/* Anonymous closure*/
var gradeCalc = function () {
    var myGrades = [93, 95, 88, 0, 55, 91];

    var average = function () {
        var total = myGrades.reduce(function (accumulator, item) {
            return accumulator + item
        }, 0);
        return 'Your average grade is ' + total / myGrades.length + '.';
    };

    var failing = function () {
        var failingGrades = myGrades.filter(function (item) {
            return item < 70;
        });

        return 'You failed ' + failingGrades.length + ' times.';
    }
    console.log(average());
    console.log(failing());
};

/* Global Import */
(function (globalVariable) {

    // Keep this variables private inside this closure scope
    var privateFunction = function() {
        console.log('Shhhh, this is private!');
    }

    // Expose the below methods via the globalVariable interface while
    // hiding the implementation of the method within the
    // function() block

    globalVariable.each = function(collection, iterator) {
        if (Array.isArray(collection)) {
            for (var i = 0; i < collection.length; i++) {
                iterator(collection[i], i, collection);
            }
        } else {
            for (var key in collection) {
                iterator(collection[key], key, collection);
            }
        }
    };

    globalVariable.filter = function(collection, test) {
        var filtered = [];
        globalVariable.each(collection, function(item) {
            if (test(item)) {
                filtered.push(item);
            }
        });
        return filtered;
    };

    globalVariable.map = function(collection, iterator) {
        var mapped = [];
        globalUtils.each(collection, function(value, key, collection) {
            mapped.push(iterator(value));
        });
        return mapped;
    };

    globalVariable.reduce = function(collection, iterator, accumulator) {
        var startingValueMissing = accumulator === undefined;

        globalVariable.each(collection, function(item) {
            if(startingValueMissing) {
                accumulator = item;
                startingValueMissing = false;
            } else {
                accumulator = iterator(accumulator, item);
            }
        });

        return accumulator;

    };

});

/*Object interface*/
var myGradesCalculate = (function () {

    // Keep this variable private inside this closure scope
    var myGrades = [93, 95, 88, 0, 55, 91];

    // Expose these functions via an interface while hiding
    // the implementation of the module within the function() block

    return {
        average: function() {
            var total = myGrades.reduce(function(accumulator, item) {
                return accumulator + item;
            }, 0);

            return'Your average grade is ' + total / myGrades.length + '.';
        },

        failing: function() {
            var failingGrades = myGrades.filter(function(item) {
                return item < 70;
            });

            return 'You failed ' + failingGrades.length + ' times.';
        }
    }
})();

/* Revealing module pattern */
var myGradesCalculate = (function () {

    // Keep this variable private inside this closure scope
    var myGrades = [93, 95, 88, 0, 55, 91];

    var average = function() {
        var total = myGrades.reduce(function(accumulator, item) {
            return accumulator + item;
        }, 0);

        return'Your average grade is ' + total / myGrades.length + '.';
    };

    var failing = function() {
        var failingGrades = myGrades.filter(function(item) {
            return item < 70;
        });

        return 'You failed ' + failingGrades.length + ' times.';
    };

    // Explicitly reveal public pointers to the private functions
    // that we want to reveal publicly

    return {
        average: average,
        failing: failing
    }
})();