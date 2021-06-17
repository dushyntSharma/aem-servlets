function formData() {
	var firstname = $("#firstname").val();
	var address = $("#address").val();
	var gender = $("#gender").val();

	console.log(firstname);
	console.log(lastname);
	console.log(gender);

	var fmdata = {
		firstname: firstname,
		address: address,
		gender: gender,
	}
	console.log(fmdata);
	$.ajax({
		type: "POST",
		url: "/bin/aemRegisterPages",
		data: {
			"data": JSON.stringify(fmdata)
		},
		success: function(data) {
			alert("sent to servlet");
		},

	});

}