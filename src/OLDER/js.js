function doClick(a)
{
var agt=navigator.userAgent.toLowerCase();
var doc = (agt.indexOf('msie')!=-1) ? top.frames("top").document : top.frames["top"].document;
for (var i = 0; i < doc.links.length; i ++)
  {
  var l = doc.links[i];
  var n = l.name;
  if (n == a)
		with (l.style)
		  {
		  color = "teal";
		  textDecoration = "none";
		  }
  else
    {
		with (l.style)
		  {
		  color = "white";
		  }
    }
  }
}