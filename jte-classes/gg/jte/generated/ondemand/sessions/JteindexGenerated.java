package gg.jte.generated.ondemand.sessions;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.util.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "sessions/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,14,14,14,15,15,15,17,17,17,17,17,17,17,17,17,18,18,20,20,20,20,20,20,20,20,20,25,25,29,29,29,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"utf-8\" />\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n    <title>Hello Hexlet!</title>\n</head>\n<body>\n<main>\n    <h1>Привет, Хекслет!</h1>\n    ");
		if (page.getCurrentUser() != null) {
			jteOutput.writeContent("\n        Добро пожаловать, ");
			jteOutput.setContext("main", null);
			jteOutput.writeUserContent(page.getCurrentUser());
			jteOutput.writeContent(".\n        Чтобы разлогиниться, удалите куку JSESSIONID из браузера\n        <a");
			var __jte_html_attribute_0 = NamedRoutes.coursesPath();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
				jteOutput.writeContent(" href=\"");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(__jte_html_attribute_0);
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(">Назад к списку курсов</a>\n    ");
		} else {
			jteOutput.writeContent("\n        <h2>Форма входа</h2>\n        <form");
			var __jte_html_attribute_1 = NamedRoutes.sessionsPath();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
				jteOutput.writeContent(" action=\"");
				jteOutput.setContext("form", "action");
				jteOutput.writeUserContent(__jte_html_attribute_1);
				jteOutput.setContext("form", null);
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(" method=\"post\">\n            <input type=\"text\" placeholder=\"Nickname\" name=\"nickname\" required class=\"form-control mb-2\" />\n            <input type=\"password\" placeholder=\"Password\" name=\"password\" required class=\"form-control mb-2\" />\n            <input type=\"submit\" value=\"Войти\" class=\"btn btn-primary\" />\n        </form>\n    ");
		}
		jteOutput.writeContent("\n</main>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
