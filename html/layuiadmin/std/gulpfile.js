/**
 layuiAdmin std 构建
*/

var pkg = require('./package.json');
var gulp = require('gulp');
var rename = require('gulp-rename')
var uglify = require('gulp-uglify');
var minify = require('gulp-minify-css');
var header = require('gulp-header');
var Stream = require('stream')
var del = require('del');


//注释
var note = [
  '/** <%= pkg.name %>-v<%= pkg.version %> <%= pkg.license %> License By <%= pkg.homepage %> */\n <%= js %>'
  , { pkg: pkg, js: ';' }
]

//构建的目标目录
var destDir = './dist'

//任务
function minjs() {
  var src = [
    './src/layuiadmin/**/*.js'
    , '!./src/layuiadmin/json/**/*.js'
    , '!./src/layuiadmin/layui/**/*.js'
    , '!./src/layuiadmin/config.js'
    , '!./src/layuiadmin/lib/extend/echarts.js'
  ];

  return gulp.src(src).pipe(uglify())
    .pipe(header.apply(null, note))
    .pipe(gulp.dest(destDir + '/layuiadmin'));
}

//压缩 CSS
function mincss() {
  var src = [
    './src/layuiadmin/**/*.css'
    , '!./src/layuiadmin/layui/**/*.css'
  ]
  var noteNew = JSON.parse(JSON.stringify(note));
  noteNew[1].js = '';

  return gulp.src(src).pipe(minify({
    compatibility: 'ie7'
  })).pipe(header.apply(null, noteNew))
    .pipe(gulp.dest(destDir + '/layuiadmin'));
}

//复制文件夹
function mv() {
  gulp.src('./src/layuiadmin/json/**/*')
    .pipe(gulp.dest(destDir + '/layuiadmin/json'));

  gulp.src('./src/layuiadmin/lib/extend/echarts.js')
    .pipe(gulp.dest(destDir + '/layuiadmin/lib/extend'));

  gulp.src('./src/layuiadmin/config.js')
    .pipe(gulp.dest(destDir + '/layuiadmin'));

  gulp.src('./src/layuiadmin/tpl/**/*')
    .pipe(gulp.dest(destDir + '/layuiadmin/tpl'));

  gulp.src('./src/layuiadmin/style/res/**/*')
    .pipe(gulp.dest(destDir + '/layuiadmin/style/res'));

  gulp.src('./src/layuiadmin/style/res/*')
    .pipe(gulp.dest(destDir + '/layuiadmin/style/res'));

  return gulp.src('./src/views/**/*')
    .pipe(gulp.dest(destDir + '/views'));
}

//复制 layui
function layui() {
  return gulp.src('./src/layuiadmin/layui/**')
    .pipe(gulp.dest('./dist/layuiadmin/layui'))
}

//清理
function clear(cb) {
  return del(['./dist/*'], cb);
}

function src() {
  return gulp.src('./dev-std/**/*')
    .pipe(gulp.dest('./src'));
}

function formatJson() {
  var stream = new Stream.Transform({ objectMode: true });
  stream._transform = function(original, unused, callback) {
    var file = original.clone({ contents: false })
    let text = file.contents.toString()
    let json = JSON.stringify(JSON.parse(text, null, 2), null, 2)
    file.contents = new Buffer(json)
    callback(null, file)
  };
  return stream;
}

function renameAndFormat() {
  return gulp.src(['./src/layuiadmin/json/**/*.js'])
  .pipe(rename(function (path) {
    path.extname = ".json";
  })).pipe(formatJson()).pipe(gulp.dest('./json'))
}

exports.convertJs = renameAndFormat
exports.default = gulp.series(clear, minjs, mincss, mv, layui, src)

