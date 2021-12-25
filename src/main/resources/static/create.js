//POST user to table
const addUser = document.getElementById("userprofile_form")
let username = document.getElementById('username')
let lastname = document.getElementById('lastname')
let age = document.getElementById('age')
let email = document.getElementById('email')
let password = document.getElementById('password')

addUser.addEventListener('submit', function (e) {
    e.preventDefault()

    fetch("/api/new", {
        method: 'POST',
        body: JSON.stringify({
            userName: username.value,
            lastName: lastname.value,
            age: age.value,
            email: email.value,
            password: password.value,
            roleString: $('#newRoles').val()

        }),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(function (response) {
            return response.json()
        })
        .then(function (data) {
            console.log(data)
        }).then(function (){
        location.href = "/admin/users"
    })

})


