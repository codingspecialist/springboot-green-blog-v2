// 1. 이벤트 리스너
$("#btn-write").click(() => {
    write();
});

// 2. 기능 함수
async function write() {
    let writeDto = {
        title: $("#title").val(),
        content: $("#content").val()
    }

    //console.log(writeDto);

    let response = await fetch("/s/post", {
        method: "POST",
        body: JSON.stringify(writeDto),
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        }
    });
    let responseParse = await response.json();

    if (responseParse.code == 1) {
        alert("글쓰기 성공");
        location.href = "/";
    } else {
        alert("글쓰기 실패");
    }
}