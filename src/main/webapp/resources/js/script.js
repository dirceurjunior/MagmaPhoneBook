/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var $body = $('body');

var backgrounds = [
    {src: '/resources/img/1.jpg', fade: 1000},
    {src: '/resources/img/2.jpg', fade: 1000}
];
$body.vegas({
    timer: false,
    slides: backgrounds
});

//background-image: url("#{resource['img:background.jpg']}");*/