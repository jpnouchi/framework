$(document).ready(function(){
//	fetchFeed('', '#feedContent1 ul');
});

function fetchFeed(url, id){
	$.jGFeed(url, 
		function(feeds){
			if(!feeds){
				alert('there was an error');
			}
			for(var i=0;i<feeds.entries.length;i++){
				var entry = feeds.entries[i];
				var title = entry.title;
				var link = entry.link;
				var description = entry.contentSnippet;
				var pubDate = entry.publishedDate;
				
				var html = "<li><a class='fancy block' href='" + link + "' target='_blank'>" + title + "</a></li>";
							
				$(id).append($(html));
			}
		}, 3);	
}

