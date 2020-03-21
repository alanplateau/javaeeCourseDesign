'use strict';
$(document).ready(function() {
  window.addEventListener('load', function() {
    $('#form-flight-input').submit(function(event) {
      if (this.checkValidity() === false) {
        event.preventDefault();
        event.stopPropagation();
      }
      $(this).addClass('was-validated');
    });
  });

  $('#input-resume').on('change', function() {
    let fileName;
    fileName = $(this)
        .val()
        .replace(/.*([\/\\])/, '');
    $(this)
      .next('.custom-file-label')
      .text(fileName);
  });
});
