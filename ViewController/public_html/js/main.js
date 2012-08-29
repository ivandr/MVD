function toggleDelCheckbox(event) {
    var src = event.getSource();
    var value = src.getValue();
    console.log(value);
    $('.SELECT_CHECKBOX').find('input:checkbox').attr('checked', value);
}

function changeRadiogroupPerson(event) {
    var src = event.getSource();// panel
    var id = src.getId();
    var value = src.getValue();
    if (value == 1)
        value = "2";//TODO не круто
    src = src.findComponent("radioText");
    changeElement(src, 'myCustomEventRadio', id, value);
}

function changeRadiogroup(event) {
    var src = event.getSource();// panel
    var id = src.getId();
    var value = src.getValue();
    console.log(id, value);
    src = src.findComponent("radioText");
    changeElement(src, 'myCustomEventRadio', id, value);
}

function changeCheckbox(event) {
    var src = event.getSource();
    var id = src.getId();
    var value = src.getValue();
    changeElement(src, 'myCustomEventCheck', id, value);
}

function changeElement(src, type, id, value) {
    AdfCustomEvent.queue(src, type, 
    // Send one parameter
    {
        value : value, id : id
    },
    // Make it "immediate" on the server
    true);
}

function clearForm(event) {
    //var src = event.getSource();
    jQuery('.clearForm').find('input, select').val('');
}