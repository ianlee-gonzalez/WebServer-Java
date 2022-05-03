/**
 * 
 */
 function validar(){
	let nome = frmContato.nome.value;
	let fone = frmContato.fone.value;
	if (nome === ""){
		alert("Campo nome obrigatório");
		frmContato.nome.focus();
		}	
	else
	if (fone === ""){
		alert("Campo fone obrigatório");
		frmContato.fone.focus();
		}
	else
		document.forms["frmContato"].submit();	
		
	
}