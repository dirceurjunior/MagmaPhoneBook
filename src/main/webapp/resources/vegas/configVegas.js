var $body = $('body');

var backgrounds = [
   {src: '/MagmaPhoneBook/faces/javax.faces.resource/01.jpg?ln=images'},
   {src: '/MagmaPhoneBook/faces/javax.faces.resource/02.jpg?ln=images'}
   //{src: '/MagmaPhoneBook/faces/javax.faces.resource/03.jpg?ln=images'}
];
$body.vegas({
   timer: false,
   overlay: '/MagmaPhoneBook/faces/javax.faces.resource/06.png?ln=vegas/overlays',
   slides: backgrounds
   //,animation: 'random'
});

