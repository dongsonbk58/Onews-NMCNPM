var express = require('express');
var router = express.Router();

var category_controller = require('../controllers/categoryController');

router.post('/list-by-level', category_controller.category_list_by_level);

router.post('/list-all', category_controller.category_list_all);

module.exports = router;
