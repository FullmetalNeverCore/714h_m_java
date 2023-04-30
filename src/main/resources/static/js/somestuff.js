function getList(){
    return $.get({
        url: '/char_list',
      }).then(function(response){
        return {status: true, value: response};
      }).catch(function(error) {
        return {status: false, error: error.status + ": " + error.statusText};
      }); 
}

function messageBuffer(){
  return $.get({
      url: '/msg_buffer',
    }).then(function(response){
      return {status: true, value: response};
    }).catch(function(error) {
      return {status: false, error: error.status + ": " + error.statusText};
    }); 
}


function verifyAccount(username, password, char) {
    return $.ajax({
      type: "POST",
      url: '/verify_credentials',
      data: JSON.stringify({"username": username, "password": password, "char": char}),
      contentType: "application/json",
    }).then(function(response) {
      if(response !== "Not"){
        return {status: true};
      }
      else{
        return {status: false, value: response};
      }
    }).catch(function(error) {
      return {status: false, error: error.status + ": " + error.statusText};
    });
  }

function sendChat(type,data) {
    console.log(type);
    return $.ajax({
      type: "POST",
      url: '/chat_exchange',
      data: {chat:data},
    }).then(function(response) {
      if(response !== "Not"){
        return {status: true};
      }
      else{
        return {status: false, value: response};
      }
    }).catch(function(error) {
      return {status: false, error: error.status + ": " + error.statusText};
    });
  }

  function send(link) {
    return $.ajax({
      type: "POST",
      url: '/img_link',
      data: {link:link},
    }).then(function(response) {
      if(response !== "Not"){
        return {status: true};
      }
      else{
        return {status: false, value: response};
      }
    }).catch(function(error) {
      return {status: false, error: error.status + ": " + error.statusText};
    });
  }


  function NeuralChar(type,text) {
    return $.ajax({
      type: "POST",
      url: '/nn_char',
      data: {type: type, val: text},
    }).then(function(response) {
      if(response !== "Not"){
        return {status: true};
      }
      else{
        return {status: false, value: response};
      }
    }).catch(function(error) {
      return {status: false, error: error.status + ": " + error.statusText};
    });
  }



  function NeuralVals(type,text) {
    return $.ajax({
      type: "POST",
      url: '/nn_vals',
      data: JSON.stringify({"type": type, "val": text}),
      contentType: "application/json",
    }).then(function(response) {
      if(response !== "Not"){
        return {status: true};
      }
      else{
        return {status: false, value: response};
      }
    }).catch(function(error) {
      return {status: false, error: error.status + ": " + error.statusText};
    });
  }

  function getTextExchange(text,engine) {
    console.log(text);
    console.log(engine);
    return $.ajax({
      type: "POST",
      url: '/chat_exchange',
      data: {chat: text,type: engine},
    }).then(function(response) {
      if(response !== "Not"){
        return {status: true};
      }
      else{
        return {status: false, value: response};
      }
    }).catch(function(error) {
      return {status: false, error: error.status + ": " + error.statusText};
    });
  }

function sendData(type,data) {
    console.log(type);
    return $.ajax({
      type: "POST",
      url: '/upload_stuff',
      data: JSON.stringify({type:type,data:data}),
      contentType: "application/json",
    }).then(function(response) {
      if(response !== "Not"){
        return {status: true};
      }
      else{
        return {status: false, value: response};
      }
    }).catch(function(error) {
      return {status: false, error: error.status + ": " + error.statusText};
    });
  }


