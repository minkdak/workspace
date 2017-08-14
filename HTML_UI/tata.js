for(var l = 0; l < classify.length; l++){
  for(var i = 0; i< dataa.result.length; i++) {
    if (dataa._response.result[i].sortno == classify[l]) {
      photoData[l] = new Array();
      console.log(photoData[l])
      photoData[l][m++] = dataa._response.result[i];


//			photoData[l].push(dataa._response.result[i])
    }

    }
  daaa[i] = ".."+dataa._response.result[i].path;
}
