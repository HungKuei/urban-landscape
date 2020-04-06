/*提交*/
$("#submitBtn").click(function () {
    if($("#username").val()==""){
        layer.msg("请输入姓名")
        return;
    };

    if($("#title").val()==""){
        layer.msg("请输入标题")
        return;
    };

    if($("#phone").val()==""){
        layer.msg("请输入手机号")
        return;
    };

    if($("#content").val()==""){
        layer.msg("说点什么吧，你的内容可以一针见血...")
        return;
    };
    $.ajax({
        type: 'POST',
        url: '/supervise',
        data: $("#supervise").serialize(),
        success: function (data){
            if(data.code==200){
                setTimeout(layer.msg("提交成功"),3000);
                location.reload();
            }
        },
        error: function () {
            setTimeout(layer.msg("系统错误"),3000);
            location.reload();
        }
    });
})

function init(pageNumber) {
    $.ajax({
        type: 'POST',
        url: '/supervise/get',
        data: {"page": (pageNumber==null? 1 : pageNumber), "limit": 10, "status":1},
        success: function (response){
            var data = response.data;
            var commentOne="";
            if(data.total==0){
                commentOne+='<div class="no-comment">暂无评论，快来占领宝座</div>';
                $("#supervise-ul").append(commentOne);
            }else{
                $.each(data.list,function (index,value) {
                    commentOne +=
                        '<li>'+
                        '	<div class="comment-body" id="comment-'+value.id+'">'+
                        '		<div class="comment-user-img">'+
                        '			<img src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png" class="img-circle"/>'+
                        '		</div>'+
                        '		<div class="comment-info">'+
                        '			<div class="comment-top">'+
                        '				<span class="comment-nickname">'+
                        '					<a href="javascript:void(0)">'+value.username+'</a>'+
                        '				</span>'+
                        '				<span class="comment-time">'+value.createTime+
                        '				</span>'+
                        '			</div>'+
                        '           <div class="comment-content">';
                    commentOne += '反馈问题：' + value.content+
                        '			</div>'+
                        '           <div class="comment-content">';
                    commentOne +='结果公示：' + value.reply +
                        '			</div>'+
                        '		</div>'+
                        '	</div> '+
                        '</li>';
                })
                $("#supervise-more").remove();
                if(data.hasNextPage){
                    commentOne+='<div id="supervise-more" data-page="'+data.nextPage+'" class="comment-more">加载更多</div>'
                }
                $("#supervise-ul").append(commentOne);
                /*加载更多*/
                $("#supervise-more").click(function () {
                    init($(this).attr("data-page"));
                })
            }
        },
        error: function () {
            layer.msg("系统错误")
            location.reload();
        }
    });
}
init();
