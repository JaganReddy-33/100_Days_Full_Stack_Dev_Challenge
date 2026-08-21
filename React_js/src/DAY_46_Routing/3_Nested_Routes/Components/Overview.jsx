const Overview = () => {
  return (
    <section>
      <div className="page-heading">
        <p>Good morning!</p>
        <h2>Application Overview</h2>
      </div>

      <div className="stats-grid">

        <div className="stat-card">
          <span>Total Applications</span>
          <strong>42</strong>
          <small>+6 this month</small>
        </div>

        <div className="stat-card">
          <span>Interviews</span>
          <strong>8</strong>
          <small>2 scheduled this week</small>
        </div>

        <div className="stat-card">
          <span>Offers</span>
          <strong>3</strong>
          <small>1 new offer</small>
        </div>

        <div className="stat-card">
          <span>Rejected</span>
          <strong>12</strong>
          <small>Keep applying 🚀</small>
        </div>

      </div>

      <div className="activity-card">
        <h3>Recent Activity</h3>

        <p>Applied to Software Engineer at Google</p>
        <p>Interview scheduled with Microsoft</p>
        <p>Application submitted to Amazon</p>
      </div>
    </section>
  );
};

export default Overview;