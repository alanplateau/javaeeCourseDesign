$(document).ready(function() {
    $.fn.dataTable.ext.classes.sPageButton =
        'paginate_button pagination-sm page-item';
    $.fn.dataTable.ext.classes.sWrapper = 'dataTables_wrapper dt-bootstrap4 p-1';

    var table = $('#airplaneInfo').DataTable();
    $('#airplaneInfo tbody').on('click', 'tr', function() {
        var modal = $('#airplaneDetailModal');
        modal.modal('toggle');
    });
});
