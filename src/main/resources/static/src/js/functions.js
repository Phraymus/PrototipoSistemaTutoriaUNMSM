

async function asignaturas() {
    const request = await fetch('../../api/asignatura', {
        method: 'GET',
        headers: {'Accept': 'application/json',
        'Content-Type': 'application/json'}
    });
    const listAsignatura = await request.json();

    let listadoHTML = '<option selected>Seleccione una asignatura</option>';


    for (let asignatura of listAsignatura) {
        let item='<option value="'+asignatura.codigo+'">'+asignatura.nombre+'</option>'
        listadoHTML += item;
    }
    document.getElementById("listAsignatura").innerHTML=listadoHTML;

}


function writeHTML(url,cont,adicional){
    // var html;
    // $.get(url,{},function(data) {
    //     html=data;
    // });

    // document.getElementById("topbar").outerHTML=html;
    $.ajax({
        type: "GET",
        url: url,
        success: function(datos) {
            $("#"+cont).html(datos+"<script>"+adicional+"</script>");
        }
    })

}