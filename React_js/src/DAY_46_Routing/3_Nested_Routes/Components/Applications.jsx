const Applications = () => {
  return (
    <section>

      <div className="page-heading">
        <p>Job Search</p>
        <h2>My Applications</h2>
      </div>

      <div className="application-list">

        <div className="application-card">
          <div>
            <h3>Google</h3>
            <p>Software Engineer</p>
          </div>

          <span className="status interview">
            Interview
          </span>
        </div>

        <div className="application-card">
          <div>
            <h3>Microsoft</h3>
            <p>Frontend Developer</p>
          </div>

          <span className="status applied">
            Applied
          </span>
        </div>

        <div className="application-card">
          <div>
            <h3>Amazon</h3>
            <p>Full Stack Developer</p>
          </div>

          <span className="status rejected">
            Rejected
          </span>
        </div>

      </div>

    </section>
  );
};

export default Applications;