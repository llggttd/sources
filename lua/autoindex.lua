local html = [[
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="0z0ne">
	<link rel="icon" href="../favicon.ico">
	<title>{{title}}</title>
	<!-- Bootstrap core CSS -->
	<link href="../static/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<div class="row text-left" style="margin-top:50px">
		{{files}}
		</div>
	</div>
	<div>
	{{log}}
	</div>
	<footer class="footer">
		<div class="container">
		</div>
    </footer>
	<script src="../static/js/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../static/js/jquery.min.js"><\/script>')</script>
	<script src="../static/js/bootstrap.min.js"></script>
</body>
</html>]]
if ngx.header.content_type == 'text/html' then
	local m, err = ngx.re.match(ngx.arg[1], "<title>(.*)</title>", 'si')
	if m then
		html = ngx.re.gsub(html, "{{title}}", m[1])
	end
	
	
	m, err = ngx.re.match(ngx.arg[1], "<hr>(.*)<hr>", "si")
	if m then
		html = ngx.re.gsub(html, "{{files}}", m[1])
	end
	
	html = ngx.re.gsub(html, "{{log}}", )
	
	ngx.arg[1] = html
end

