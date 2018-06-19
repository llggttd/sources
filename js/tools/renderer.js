const { ipcRenderer } = require('electron')

$(document).ready(() => {
    $('.search-input button').on('click', () => {
        let input = $('.search-input input').val();
        ipcRenderer.send('user-info-query', input);
        disableQueryButton()
    })
})

function disableQueryButton () {
    $('.search-input button').prop('disabled', true);
}

function enableQueryButton () {
    $('.search-input button').prop('disabled', false);
}

function refreshHighLight() {
    $('pre code').each(function(i, block) {
        hljs.highlightBlock(block);
    });    
}

ipcRenderer.on('user-info-result', (event, arg) => {
    $('pre code').html(JSON.stringify(arg, undefined, 2))
    refreshHighLight();
    enableQueryButton()
})
