var tutorSelect;
var tutoradoSelect;
var idInform;
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
            'onclick="loadTutorId(\''+tutor.id+'\',\''+tutor.persona.nombre+'\',\''+tutor.persona.apellidoPaterno+'\',\''+tutor.persona.apellidoMaterno+'\')" type="button" value="Seleccionar" data-bs-dismiss="modal"></td>\n' +
        '              </tr>';
        listadoHTML += item;
    }
    document.getElementById("listTutores").innerHTML=listadoHTML;
}

function loadTutorId(id,nombre,apellidoP,apellidoM) {
    tutorSelect=id;
    nombres=nombre+" "+apellidoP+" "+apellidoM;
    document.getElementById("tutorId").innerHTML=nombres;
}

function loadTutoradoId(id,nombre,apellidoP,apellidoM) {
    tutoradoSelect=id;
    nombres=nombre+" "+apellidoP+" "+apellidoM;
    document.getElementById("tutoradoId").innerHTML=nombres;
}

async function loadTutorado() {
    const request = await fetch('../../api/tutorado', {
        method: 'GET',
        headers: {'Accept': 'application/json',
        'Content-Type': 'application/json'}
    });
    const listTutorado = await request.json();

    let listadoHTML = '';


    for (let tutorado of listTutorado) {
        let item='<tr>\n' +
        '                <th scope="row">'+tutorado.codigo+'</th>\n' +
        '                <td>'+tutorado.persona.nombre+'</td>\n' +
        '                <td>'+tutorado.persona.apellidoPaterno+'</td>\n' +
        '                <td>'+tutorado.persona.apellidoMaterno+'</td>\n' +
        '                <td><input class="btn btn-success" ' +
            'onclick="loadTutoradoId(\''+tutorado.id+'\',\''+tutorado.persona.nombre+'\',\''+tutorado.persona.apellidoPaterno+'\',\''+tutorado.persona.apellidoMaterno+'\')" type="button" value="Seleccionar" data-bs-dismiss="modal"></td>\n' +
        '              </tr>';
        listadoHTML += item;
    }
    document.getElementById("listTutorados").innerHTML=listadoHTML;
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

    $('#registerSesion').modal('show');
    //window.location.href='dashboard.html';
    //const usuarios = await request.json();
}

async function addInforme() {
    let datos={};
    datos.id=idInform;
    datos.informe=document.getElementById('txtInforme').value;
    datos.observacion=document.getElementById('txtObservacion').value;


    const request = await fetch('../../api/sesion', {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    $('#registerSesion').modal('show');
    //window.location.href='dashboard.html';
    //const usuarios = await request.json();
}

async function loadSesiones() {
    let id=localStorage.persona_id;

    const request = await fetch('../../api/sesion/'+id, {
        method: 'GET',
        headers: {'Accept': 'application/json',
            'Content-Type': 'application/json'}
    });
    const sesiones = await request.json();

    let listadoHTML = '';

    const request1 = await fetch('../../api/persona/'+sesiones[0].tutorado, {
        method: 'GET',
        headers: {'Accept': 'application/json',
            'Content-Type': 'application/json'}
    });

    const request2 = await fetch('../../api/persona/'+sesiones[0].tutor, {
        method: 'GET',
        headers: {'Accept': 'application/json',
            'Content-Type': 'application/json'}
    });

    const request3 = await fetch('../../api/asignatura/'+sesiones[0].asignatura, {
        method: 'GET',
        headers: {'Accept': 'application/json',
            'Content-Type': 'application/json'}
    });

    const persona = await request1.json();
    const persona2 = await request2.json();
    const asignatura=await request3.json();

    for (let sesion of sesiones) {
        let btnInformation='<a href="#" onclick="idInform='+sesion.id+';reportForm(\''+sesion.informe+'\',\''+sesion.observacion+'\')" class="badge bg-success" >\n' +
            '                                        <i class="bi bi-grid"></i>\n' +
            '                                        Informe\n' +
            '                                    </a>';
        let btnReport='<a href="#" class="badge bg-warning">\n' +
            '                                        <i class="bi bi-clipboard"></i>\n' +
            '                                        Reporte\n' +
            '                                    </a>';

        const fecha=new Date(sesion.fecha);
        const tipo=(sesion.tipo=="A")?"Alto rendimiento":(sesion.tipo=="G")?"Tutoria individual o grupal":(sesion.tipo=="M")?"Matricula condicionada":"";

        let sesionHTML = '<tr>\n' +
            '                <th scope="row">'+sesion.id+'</th>\n' +
            '                <td>'+persona.dni+'</td>\n' +
            '                <td>'+persona2.dni+'</td>\n' +
            '                <td>'+asignatura.nombre+'</td>\n' +
            '                <td>'+fecha.toLocaleDateString()+'</td>\n' +
            '                <td>'+sesion.hora+'</td>\n' +
            '                <td>'+tipo+'</td>\n' +
            '                <td>'+btnInformation+btnReport+'</td>\n' +
            '              </tr>';
        listadoHTML += sesionHTML;
    }

    document.getElementById('#contSesiones').outerHTML=listadoHTML;
}

function reportForm(informe, observacion) {
    informeFormat=(informe=="null")?"":informe;
    observacionFormat=(observacion=="null")?"":observacion;
    document.getElementById("txtInforme").value=informeFormat;
    document.getElementById("txtObservacion").value=observacionFormat;
    $('#listFormInforme').modal('show');
}