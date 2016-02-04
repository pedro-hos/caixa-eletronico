var gulp = require('gulp'),
    connect = require('gulp-connect');
 
gulp.task('connect', function() {
  connect.server({
    root: 'public',
    port:9000,
    livereload: true
  });
});
 
gulp.task('html', function () {
  gulp.src('./public/{,*/}*.html')
    .pipe(connect.reload());
});

gulp.task('js', function () {
  gulp.src('./public/js/{,*/}*.js')
    .pipe(connect.reload());
});

gulp.task('styles', function () {
  gulp.src('./public/styles/{,*/}*.css')
    .pipe(connect.reload());
});
 
gulp.task('watch', function () {
  gulp.watch(['./public/{,*/}*.html'], ['html']);
  gulp.watch(['./public/js/{,*}/*.js'], ['js']);
  gulp.watch(['./public/styles/{,*/}*.css'], ['styles']);
});
 
gulp.task('default', ['connect', 'watch']);