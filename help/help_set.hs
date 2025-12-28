
<helpset version="1.0">
	<title> Ayuda para la aplicación Peluqueria Canina</title>
	<maps>
		<!-- Página por defecto al mostrar la yuda -->
		<homeID>aplicacion</homeID>
		<!-- Que mapa deseamos -->
		<mapref location = "map.jhm"/>
	</maps>
	<!-- Las vistas que deseamos mostrar en la ayuda -->
	<!-- La tabla de contenidos -->
	<view>
		<name> Tabla de contenidos</name>
		<label> Tabla de contenidos</label>
		<type>javax.help.TOCView</type>
		<data>toc.xml</data>
	</view>

	<!-- El índice -->
	<view>
		<name>Indice</name>
		<label>El índice</label>
		<type>javax.help.IndexView</type>
		<data>indice.xml</data>
	</view>

	<!-- La pestaña de búsqueda -->
	<view>
		<name>Buscar</name>
		<label>Buscar</label>
		<type>javax.help.SearchView</type>
		<data engine="com.sun.java.help.search.DefaultSearchEngine">JavaHelpSearch</data>
	</view>
</helpset>