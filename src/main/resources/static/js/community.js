function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    if(!content){
        alert("请输入回复内容");
        return
    }
    console.log(questionId);
    console.log(content);
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": questionId,
            "content": content,
            "type": 1
        }),
        success: function (response) {

            if (response.code == 200) {
                window.location.reload()

            } else {
                if (response.code == 2003) {
                    var isAccpted = confirm(response.message);

                    if (isAccpted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=08937290359057a5f107&redirect_uri=http://localhost:8886/callback&scope=user&state=1")
                        window.localStorage.setItem("closable", true);
                    }
                } else {
                    alert(response.message)
                }

            }

        },

        dataType: "json"
    });

}