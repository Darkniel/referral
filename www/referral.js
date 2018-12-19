var exec = require('cordova/exec');

exports.getReferrer = function (arg0, success, error) {
    exec(success, error, 'Referral', 'getReferrer', [arg0]);
};
