function confirmDelete(button) {
      var form = button.closest('form');
      var hiddenInput = form.querySelector('input[name="todoId"]');
      var todoId = hiddenInput.value;

      if (confirm('Are you sure you want to delete this todo?')) {
          form.submit();
      }
}

function updateTodoStatus(checkbox) {
    var form = checkbox.closest('div');
    var todoId = form.getAttribute('value');
    var completedInput = form.querySelector('input[name="completed"]');
    completedInput.value = checkbox.checked;

    var xhr = new XMLHttpRequest();
    var params = "completed=" + checkbox.checked;
    xhr.open('POST', '/todos/update/complete/' + todoId, true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(params);
}