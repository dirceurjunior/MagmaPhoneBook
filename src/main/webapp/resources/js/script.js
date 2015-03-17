/*!
 * AdicionaMascara
 * Version : 1.0.0
 * By Dirceu Junior
 */

$(document).ready(function () {
   setarMascara();
});

function setarMascara() {
   $("#inpValor").maskMoney({showSymbol: false, symbol: "", precision: 2, decimal: ",", thousands: "."});
   $("#cep").inputmask("99999-999");
   $("#cpf").inputmask("999.999.999-99");
   $("#cnpj").inputmask("99.999.999/9999-99");
   $("#fonefixo").inputmask("(99) 9999-9999");
   $("#fonecomercial").inputmask("(99) 9999-9999");
   $("#fonecelular").inputmask("(99) 99999-9999");
   $("#dataNascimento").inputmask("99/99/9999");
   $("#dataCadastro").inputmask("99/99/9999");
   $("#dataPagamento").inputmask("99/99/9999");
}

/*!
 * EnterDisable 1.0
 * Version : 1.0.0
 * By Dirceu Junior
 */

function setaFoco(elemento) {
   var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
   if (keyCode == 13) {
      var i;
      for (i = 0; i < elemento.form.elements.length; i++)
         if (elemento == elemento.form.elements[i])
            break;
      i = (i + 1) % elemento.form.elements.length;
      elemento.form.elements[i].focus();
      event.preventDefault();
      return false;
   }
   return false;
}

