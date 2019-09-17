# Change this to your URL
$domain = "https://transentia.github.io/helloworlds/html"

# file extensions to include in sitemap
$extensions = ".html"

# wrap file information in XML tags
function wrap
{
    begin
    {
        '<?xml version="1.0" encoding="UTF-8"?>'
        '<urlset         xmlns="http://www.sitemaps.org/schemas/sitemap/0.9"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.sitemaps.org/schemas/sitemap/0.9
            http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd">'
    }

    process
    {
        if ($extensions -contains $_.extension)
        {
        "`t<url>"
        "`t`t<loc>$domain/$_</loc>"
        "`t`t<lastmod>2019-09-12T16:30:00+10:00</lastmod>"
        "`t<priority>0.75</priority>"
        "`t</url>"
        }
    }

    end
    {
        "</urlset>"
    }
}

dir | wrap | out-file -encoding ASCII ..\..\sitemap_HELLOWORLDS.xml