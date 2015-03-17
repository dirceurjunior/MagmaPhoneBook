var $body = $('body');

var backgrounds = [
   {src: '/MagmaPhoneBook/faces/javax.faces.resource/1.jpg?ln=img'},
   {src: '/MagmaPhoneBook/faces/javax.faces.resource/2.jpg?ln=img'}
];
$body.vegas({
   timer: false,
   overlay: '/MagmaPhoneBook/faces/javax.faces.resource/06.png?ln=vegas/overlays',
   slides: backgrounds
});

