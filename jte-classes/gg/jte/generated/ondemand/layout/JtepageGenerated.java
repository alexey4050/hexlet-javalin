package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,25,25,25,25,25,25,25,25,25,25,43,43,43,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content) {
		jteOutput.writeContent("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Мой сайт</title>\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n</head>\n<body>\n<header>\n    <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n        <div class=\"container-fluid\">\n            <a class=\"navbar-brand\" href=\"/\">Мой сайт</a>\n            <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\"\n                    aria-label=\"Toggle navigation\">\n                <span class=\"navbar-toggler-icon\"></span>\n            </button>\n            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n                <ul class=\"navbar-nav\">\n                    <li class=\"nav-item\">\n                        <a class=\"nav-link\" href=\"/\">Главная</a>\n                    </li>\n                    <li class=\"nav-item\">\n                        <a class=\"nav-link\"");
		var __jte_html_attribute_0 = org.example.hexlet.util.NamedRoutes.buildUserPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Создать пользователя</a>\n                    </li>\n                </ul>\n            </div>\n        </div>\n    </nav>\n</header>\n\n<main class=\"container mt-4\">\n    @render\n</main>\n\n<footer class=\"bg-light text-center py-3\">\n    <p>&copy; 2023 <a href=\"https://github.com/alexey4050\" target=\"_blank\">Ваш профиль на GitHub</a></p>\n</footer>\n<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\"></script>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, content);
	}
}
