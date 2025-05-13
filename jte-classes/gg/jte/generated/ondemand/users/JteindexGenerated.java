package gg.jte.generated.ondemand.users;
import org.example.hexlet.util.NamedRoutes;
import org.example.hexlet.dto.users.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,14,14,16,16,17,17,19,19,19,19,19,19,19,19,19,19,19,19,20,20,20,22,22,23,23,24,24,24,26,26,26,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <h1>Список пользователей</h1>\n    <form action=\"/users\" method=\"get\">\n        <input type=\"search\" required name=\"term\" placeholder=\"Поиск пользователей\">\n        <input type=\"submit\" value=\"Искать\">\n    </form>\n\n    ");
				if (page.getUsers().isEmpty()) {
					jteOutput.writeContent("\n        <p>Пока не добавлено ни одного пользователя</p>\n    ");
				} else {
					jteOutput.writeContent("\n        ");
					for (var user : page.getUsers()) {
						jteOutput.writeContent("\n            <div>\n                <h2><a");
						var __jte_html_attribute_0 = NamedRoutes.userPath(user.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_0);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(user.getName());
						jteOutput.writeContent("</a></h2>\n                <p>");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(user.getEmail());
						jteOutput.writeContent("</p>\n            </div>\n        ");
					}
					jteOutput.writeContent("\n    ");
				}
				jteOutput.writeContent("\n");
			}
		}, page);
		jteOutput.writeContent("\n\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
