package gg.jte.generated.ondemand.courses;
import org.example.hexlet.model.Course;
public final class JtedetailGenerated {
	public static final String JTE_NAME = "courses/detail.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,5,5,5,5,8,8,8,9,9,9,12,12,12,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Course course) {
		jteOutput.writeContent("\n<html>\n    <head>\n        <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(course.getName());
		jteOutput.writeContent("</title>\n    </head>\n    <body>\n        <h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(course.getName());
		jteOutput.writeContent("</h1>\n        <p>");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(course.getDescription());
		jteOutput.writeContent("</p>\n        <a href=\"/courses\">Назад к списку курсов</a>\n    </body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Course course = (Course)params.get("course");
		render(jteOutput, jteHtmlInterceptor, course);
	}
}
