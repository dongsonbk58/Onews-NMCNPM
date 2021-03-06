var User = require('../models/user');

var async = require('async');

exports.user_detail_id_post = function (req, res) {

  User.findById(req.params.id)
    .exec(function (err, user) {
      if (err) { return next(err); }
      res.send({ user: user });
    });

};

exports.user_detail_username_post = function (req, res) {
  User.find({ username: req.params.username })
    .exec(function (err, user) {
      if (err) { return next(err); }
      res.send({ user: user });
    });

};

exports.user_create_post = function (req, res) {
  req.checkBody('username', 'Username must be specified.').notEmpty();
  req.checkBody('full_name', 'Full name must be specified.').notEmpty();

  var errors = req.validationErrors();

  var user = new User(
    {
      username: req.body.username,
      full_name: req.body.full_name,
      email: req.body.email,
      date_of_birth: null,
      gender: null,
      password: null
    });

  if (req.body.type == 'f') {
    user.face_id = req.body.face_id;
  } else if (req.body.type == 'g') {
    user.google_id = req.body.google_id;
  } else {
    user.password = req.body.password;
  }

  if (errors) {
    res.send({ user: user, errors: errors });
    return;

  } else {
    var isExist = true;
    var response = {};
    var currentUser = {};

    async.series([

      function (callback) {
        User.find({ username: user.username })
          .exec(function (err, foundUser) {
            if (err) { return callback(err); }
            currentUser = foundUser;
            isExist = foundUser.length > 0 ? true : false;
            callback();
          });
      },

      function (callback) {
        if (!isExist) {
          user.save(function (err) {
            if (err) { return callback(err); }
            response.success = 'Successfully';
            callback();
          });
        } else {
          response.user = currentUser;
          response.error = 'User already existed';
          callback();
        }
      }
    ], function (err) {
      if (err) return next(err);
      res.send(response);
    });
  }

};

exports.user_authenticate_post = function (req, res) {

  User.find({ username: req.body.username, password: req.body.password })
    .exec(function (err, user) {
      if (err) { return next(err); }

      var isExist = user.length > 0 ? true : false;

      if (isExist) {
        res.send({ success: 'Successfully', user: user });
      } else {
        res.send({ error: 'Authentication failed' });
      }
    });

};

exports.user_update_post = function (req, res) {

  req.checkBody('username', 'Username must be specified.').notEmpty();
  req.checkBody('full_name', 'Full name must be specified.').notEmpty();

  var errors = req.validationErrors();
  req.sanitize('date_of_birth').toDate();

  if (errors) {
    res.send({ errors: errors });
    return;

  } else {

    // User.findOneAndUpdate({ username: req.body.username }, user, {}, function(err, user) {
    //   if (err) { return next(err); }
      
    //   res.send({user: user, success: 'Successfully'});
    // })

    User.findOne({ username: req.body.username })
      .exec(function (err, found_user) {

        if (err) { return next(err); }

        if (found_user) {
          var user = new User(
            {
              username: req.body.username,
              full_name: req.body.full_name,
              email: req.body.email,
              date_of_birth: req.body.date_of_birth,
              gender: req.body.gender,
              password : found_user.password,
              _id : found_user.id
            });

          User.findByIdAndUpdate(found_user.id, user, {}, function (err,newUser) {
            if (err) { return next(err); }
               //successful - redirect to genre detail page.
               res.send({user: newUser, success: 'Successfully'});
            });
        }
        else {
          res.send({error: 'User not found'});
        }

      });

  }

};

