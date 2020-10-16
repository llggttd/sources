/**
 layuiAdmin pro 构建
*/

var pkg = require('./package.json');
var gulp = require('gulp');
var minify = require('gulp-minify-css');
var header = require('gulp-header');
var del = require('del');

//注释
let note = [
  '/** <%= pkg.name %>-v<%= pkg.version %> <%= pkg.license %> License By <%= pkg.homepage %> */\n <%= js %>'
  , { pkg: pkg, js: ';' }
]

//构建的目标目录
let destDir = './dist'

//发行版本目录
let releaseDir = '../pack/layuiAdmin.pack/' + pkg.name + '-v' + pkg.version

//压缩 JS
function minjs() {
  var src = [
    './src/**/*.js'
    , '!./src/config.js'
    , '!./src/lib/extend/echarts.js'
  ];

  return gulp.src(src)
    // .pipe(uglify())
    .pipe(header.apply(null, note))
    .pipe(gulp.dest(destDir));
}

//压缩 CSS
function mincss() {
  var src = ['./src/**/*.css']
    , noteNew = JSON.parse(JSON.stringify(note));
  noteNew[1].js = '';
  return gulp.src(src).pipe(minify({
    compatibility: 'ie7'
  })).pipe(header.apply(null, noteNew))
    .pipe(gulp.dest(destDir));
}

//复制文件夹
function mv() {
  gulp.src('./src/config.js')
    .pipe(gulp.dest(destDir));

  gulp.src('./src/lib/extend/echarts.js')
    .pipe(gulp.dest(destDir + '/lib/extend'));

  gulp.src('./src/style/res/**/*')
    .pipe(gulp.dest(destDir + '/style/res'));

  return gulp.src('./src/views/**/*')
    .pipe(gulp.dest(destDir + '/views'));
}

//清理
function clear(cb) {
  return del(['./dist/*'], cb);
}

function clearRelease(cb) {
  return del(['./json/*', releaseDir], cb);
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
  return gulp.src(['./start/json/**/*.js'])
  .pipe(rename(function (path) {
    path.extname = ".json";
  })).pipe(formatJson()).pipe(gulp.dest('./json'))
}


function src() { //命令：gulp src
  return gulp.src('./dev-src/**/*').pipe(gulp.dest('./src'));
}

exports.default = gulp.series(clear, minjs, mincss, mv, src)
