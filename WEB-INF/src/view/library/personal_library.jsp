<jsp:include page="/WEB-INF/src/view/header.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>


<div class="tabbable" style="margin-bottom: 9px;">
        <ul class="nav nav-tabs">
          <li class="active"><a href="#1" data-toggle="tab">Owned Records</a></li>
          <li><a href="#2" data-toggle="tab">Flaged Records</a></li>
          <li><a href="#3" data-toggle="tab">Playlists</a></li>
        </ul>
        <div class="tab-content">
          <div class="tab-pane active" id="1">
            <p>I'm in Section 1.</p>
          </div>
          <div class="tab-pane" id="2">
            <p>Howdy, I'm in Section 2.</p>
          </div>
          <div class="tab-pane" id="3">
            <p>What up girl, this is Section 3.</p>
          </div>
        </div>
      </div>

<jsp:include page="/WEB-INF/src/view/footer.jsp" />