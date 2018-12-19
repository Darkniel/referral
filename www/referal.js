var exec = require('cordova/exec');

exports.getReferer = function (arg0, success, error) {
    exec(success, error, 'referal', 'getReferer', [arg0]);
};
