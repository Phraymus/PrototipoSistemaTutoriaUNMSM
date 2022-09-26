var tutorSelect;
var tutoradoSelect;
var solicitudSelect;


async function loadSolicitud() {
    let id=localStorage.persona_id;

    const request = await fetch('../../api/solicitud/'+id, {
        method: 'GET',
        headers: {'Accept': 'application/json',
        'Content-Type': 'application/json'}
    });
    const solicitudes = await request.json();

    let listadoHTML = '';

    const request2 = await fetch('../../api/persona/'+solicitudes[0].tutorado, {
        method: 'GET',
        headers: {'Accept': 'application/json',
            'Content-Type': 'application/json'}
    });

    const request3 = await fetch('../../api/asignatura/'+solicitudes[0].asignatura, {
        method: 'GET',
        headers: {'Accept': 'application/json',
            'Content-Type': 'application/json'}
    });

    const persona = await request2.json();
    const asignatura=await request3.json();



    for (let solicitud of solicitudes) {
        var date=new Date(solicitud.fecha);
        var estado=(solicitud.estado=="E")?"En proceso":(solicitud.estado=="A")?"Aceptado":"Rechazado";
        var tipo=(solicitud.tipo=="M")?"Matricula condicionada":"Curso repetido";
        var display="";

        if (localStorage.perfil=="E"){
            display="d-none";
            document.getElementById("accion").className="d-none";
        }

        let solicitudHTML = '<tr>\n' +
            '                <th scope="row">'+solicitud.id+'</th>\n' +
            '                <td>'+persona.nombre+' '+persona.apellidoPaterno+' '+persona.apellidoMaterno+'</td>\n' +
            '                <td>'+tipo+'</td>\n' +
            '                <td>'+asignatura.nombre+'</td>\n' +
            '                <td>'+date.toLocaleDateString()+'</td>\n' +
            '                <td>'+estado+'</td>\n' +
            '                <td class="'+display+'"> ' +
            '                   <select id="cmbAccion'+solicitud.id+'" class="form-select">' +
            '                       <option value="E">Seleccione</option>' +
            '                       <option value="A" onclick="addSesionForm(\''+persona.id+'\',\''+solicitud.tipo+'\',\''+asignatura.codigo+'\',\''+date.getFullYear()+'\',\''+(date.getMonth()+1)+'\',\''+date.getDate()+'\',\''+solicitud.id+'\')">Aceptar</option>' +
            '                       <option value="R" onclick="deleteSesion('+solicitud.id+')">Rechazar</option>' +
            '                   </select>' +
            '               </td>\n' +
            '              </tr>';

        listadoHTML += solicitudHTML;
        document.getElementById('#contSolicitudes').outerHTML+=solicitudHTML;
        document.getElementById("cmbAccion"+solicitud.id).value=solicitud.estado;

    }

    // document.getElementById('#contSolicitudes').outerHTML=listadoHTML;
}

function addSesionForm(id,tipo,asignatura,año,mes,dia,idSolicitud) {
    const mesFormat=(mes<10)?"0"+mes:mes;
    $('#addSesion').modal('show');
    tutoradoSelect=id;
    solicitudSelect=idSolicitud;
    document.getElementById("listTipo").value=tipo;
    document.getElementById("listAsignatura").value=asignatura;
    document.getElementById("txtFecha").value=año+"-"+mesFormat+"-"+dia;
}

function deleteSesion(idSolicitud) {
    solicitudSelect=idSolicitud;
    updateEstado("R");
}


async function addSesion() {
    let datos={};
    datos.asunto="Sesión de tutoría académica";
    datos.tipo=document.getElementById('listTipo').value;
    datos.tutorado=tutoradoSelect;
    datos.asignatura=document.getElementById('listAsignatura').value;
    datos.resolucion=document.getElementById('txtResolucion').value;
    datos.fecha=document.getElementById('txtFecha').value;
    datos.hora=document.getElementById("txtHora").value;
    datos.tutor=tutorSelect;


    const request = await fetch('../../api/sesion', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    updateEstado("A");

    //window.location.href='dashboard.html';
    //const usuarios = await request.json();
}

async function updateEstado(estado) {
    let datos={};
    datos.id=solicitudSelect;
    datos.estado=estado;

    const request = await fetch('../../api/solicitud', {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    const respuest=request.json();

    $('#registerSesion').modal('show');


}

async function addSolicitud() {
    let datos={};
    datos.asunto=document.getElementById('txtAsunto').value;
    datos.tipo=document.getElementById('listTipo').value;
    datos.fecha=document.getElementById('txtFecha').value;
    datos.tutorado=localStorage.persona_id;
    datos.asignatura=document.getElementById('listAsignatura').value;


    const request = await fetch('../../api/solicitud', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    $('#registerSesion').modal('show');

    //const usuarios = await request.json();
}

async function loadTutor() {
    const request = await fetch('../../api/tutor', {
        method: 'GET',
        headers: {'Accept': 'application/json',
            'Content-Type': 'application/json'}
    });
    const listTutor = await request.json();

    let listadoHTML = '';


    for (let tutor of listTutor) {

        const estado=(tutor.estado=="D")?"Disponible":"No disponible";
        let item='<tr>\n' +
            '                <th scope="row">'+tutor.codigo+'</th>\n' +
            '                <td>'+tutor.persona.nombre+'</td>\n' +
            '                <td>'+tutor.persona.apellidoPaterno+'</td>\n' +
            '                <td>'+tutor.persona.apellidoMaterno+'</td>\n' +
            '                <td>'+estado+'</td>\n' +
            '                <td><input class="btn btn-success" ' +
            'onclick="tutorSelect='+tutor.id+'; $(\'#listDocentes\').modal(\'hide\'); $(\'#addSesion\').modal(\'show\');  " type="button" value="Seleccionar"></td>\n' +
            '              </tr>';
        listadoHTML += item;
    }
    document.getElementById("listTutores").innerHTML=listadoHTML;

    $('#addSesion').modal('hide');
    $('#listDocentes').modal('show');
}